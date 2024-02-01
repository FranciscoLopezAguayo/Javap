export interface ProfileResponse{
    id: string,
    username: string,
    name:string,
    email:string,
    role:string,
    enabled:string,
    authorities:authoritys[]
    
}

export interface authoritys{
    authority: string
}