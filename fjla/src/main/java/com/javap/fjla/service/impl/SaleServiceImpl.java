package com.javap.fjla.service.impl;

import com.javap.fjla.dto.*;
import com.javap.fjla.exception.ObjectNotFoundException;
import com.javap.fjla.persistance.entity.Product;
import com.javap.fjla.persistance.entity.Sale;
import com.javap.fjla.persistance.entity.Sale_Item;
import com.javap.fjla.persistance.entity.User;
import com.javap.fjla.persistance.repository.ProductRepository;
import com.javap.fjla.persistance.repository.SaleRepository;
import com.javap.fjla.persistance.repository.Sale_ItemRepository;
import com.javap.fjla.persistance.repository.UserRepository;
import com.javap.fjla.service.SaleService;
import jakarta.persistence.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private Sale_ItemRepository saleItemRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

//    @Override
//    public Page<Sale> findAll(Pageable pageable) {return saleRepository.findAll(pageable);}
//
//    @Override
//    public Page<Sale> findAllBycustomer(String customer, Pageable pageable) {
//
//        User UserFromDB = userRepository.findByUsername(customer)
//                .orElseThrow( () -> new ObjectNotFoundException("User not found with username " + customer));
//
//        //Page<Sale> ComprasCustomer = saleRepository.findAll(pageable);
//        Page<Sale> ComprasCustomer = saleRepository.findBycustomer(UserFromDB,pageable);
//
//        return ComprasCustomer;
//    }
//
//    @Override
//    public List<Sale> findAllSalesBycustomer(String customer) {
//        User UserFromDB = userRepository.findByUsername(customer)
//                .orElseThrow( () -> new ObjectNotFoundException("User not found with username " + customer));
//
//        //Page<Sale> ComprasCustomer = saleRepository.findAll(pageable);
//        //List<Sale> ComprasCustomer = saleRepository.findAll(User UserFromDB);
//
//        return null;
//    }

    @Override
    public List<Sale> findUserSales(String username, Pageable pageable) {
        User UserFromDB = userRepository.findByUsername(username)
                .orElseThrow( () -> new ObjectNotFoundException("User not found with username " + username));


        //userRepository.findByRolesIn(Arrays.asList(userRole), pageable);
        return saleRepository.findByCustomer(UserFromDB,pageable);
    }


    @Override
    public RegisteredSale createOne(SaveSale saveSale, User userVendedor) {
        Date date = new Date();
        BigDecimal SaleAmountTOTAL = BigDecimal.valueOf(0.0);
        //Optional<User> userRepo = userRepository.findByUsername(saveSale.getCustomer());

        User UserFromDB = userRepository.findByUsername(saveSale.getCustomer())
                .orElseThrow( () -> new ObjectNotFoundException("User not found with username " + saveSale.getCustomer()));

        System.out.println("UserFromDB "+ UserFromDB.toString());

        Sale sale = new Sale();
        sale.setSalesPerson(userVendedor);
        sale.setCustomer(UserFromDB);
        sale.setSaleDate(date);
        sale.setSaleAmount(SaleAmountTOTAL);


        List<SaveSale_Item> listaDeItems = saveSale.getItems();

        //LISTA DTO Lista Items
        List<RegisteredSale_Item> DTOregisteredSaleItems = new ArrayList<>();

        sale = saleRepository.save(sale);
        System.out.println("venta guardada ");

        for (SaveSale_Item item : listaDeItems) {
            BigDecimal SaleItemAmount = BigDecimal.valueOf(0.0);
            //buscar si existe producto en BD
            Product productFromDB = productRepository.findById(item.getProductId())
                    .orElseThrow( () -> new ObjectNotFoundException("Product not found with ID " + item.getProductId()));

            //vincular los items con la venta
            Sale_Item saleItem = new Sale_Item();

            saleItem.setSale(sale);
            saleItem.setProduct(productFromDB);
            saleItem.setQty(item.getQty());

            //asi se suman los big decimals
            SaleItemAmount = SaleItemAmount.add(productFromDB.getPrice());
            //convertir int a big decimal
            BigDecimal X_qty = new BigDecimal(Integer.toString(item.getQty()));
            //asi se multiplica
            SaleItemAmount = SaleItemAmount.multiply(X_qty);
            saleItem.setProductSaleAmount(SaleItemAmount);

            SaleAmountTOTAL = SaleAmountTOTAL.add(SaleItemAmount);

            saleItemRepository.save(saleItem);



            //DTO PRODUCTO
            RegisteredProduct DTOregisteredProduct = new RegisteredProduct();
            DTOregisteredProduct.setId(productFromDB.getId());
            DTOregisteredProduct.setName(productFromDB.getName());
            DTOregisteredProduct.setPrice(productFromDB.getPrice());

            //DTO SALEITEM
            RegisteredSale_Item DTOregisteredSaleItem = new RegisteredSale_Item();
            DTOregisteredSaleItem.setProduct(DTOregisteredProduct);
            DTOregisteredSaleItem.setQty(saleItem.getQty());
            DTOregisteredSaleItem.setProductSaleAmount(saleItem.getProductSaleAmount());

            DTOregisteredSaleItems.add(DTOregisteredSaleItem);

        }

        sale.setSaleAmount(SaleAmountTOTAL);
        sale = saleRepository.save(sale);

        RegisteredUser DTOUserSalesPerson = new RegisteredUser();
        DTOUserSalesPerson.setId(userVendedor.getId());
        DTOUserSalesPerson.setUsername(userVendedor.getUsername());
        DTOUserSalesPerson.setName(userVendedor.getName());
        DTOUserSalesPerson.setRole(userVendedor.getRole().name());

        RegisteredUser DTOUserCustomer = new RegisteredUser();
        DTOUserCustomer.setId(UserFromDB.getId());
        DTOUserCustomer.setUsername(UserFromDB.getUsername());
        DTOUserCustomer.setName(UserFromDB.getName());
        DTOUserCustomer.setRole(UserFromDB.getRole().name());


        RegisteredSale registeredSale = new RegisteredSale();
        registeredSale.setSalesPerson(DTOUserSalesPerson);
        registeredSale.setCustomer(DTOUserCustomer);
        registeredSale.setSaleAmount(sale.getSaleAmount());
        registeredSale.setSaleDate(sale.getSaleDate());
        registeredSale.setItems(DTOregisteredSaleItems);


        //return sale;
        return registeredSale;
    }

    @Override
    public Page<Sale> findAll(Pageable pageable) {
        return saleRepository.findAll(pageable);
    }

//    @Override
//    public Page<RegisteredSale> findAll(Pageable pageable) {
//        Page<Sale> entities = saleRepository.findAll(pageable);
//        Page<RegisteredSale> Sales = saleRepository.findAll(pageable);
//        return Sales;
//    }


    //    public Optional<Product> findOneById(Long productId) {
    //        return productRepository.findById(productId);
    //    }
    @Override
    public Optional<Sale> findOneById(Long SaleId) {
        return saleRepository.findById(SaleId);
    }



//    private RegisteredSale convertToDto(Sale sale) {
//        RegisteredSale RegisteredSaleDto = modelMapper.map(sale, RegisteredSale.class);
//        return RegisteredSaleDto;
//    }
//
//    private Sale convertToEntity(RegisteredSale RegisteredSaleDto) throws ParseException {
//        Sale sale = modelMapper.map(RegisteredSaleDto, Sale.class);
//        return sale;
//    }


}
