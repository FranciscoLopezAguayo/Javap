import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SessionStorageDemoComponent } from './session-storage-demo.component';

describe('SessionStorageDemoComponent', () => {
  let component: SessionStorageDemoComponent;
  let fixture: ComponentFixture<SessionStorageDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SessionStorageDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SessionStorageDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
