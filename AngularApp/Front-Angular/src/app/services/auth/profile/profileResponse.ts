export interface ProfileResponse{
    id: string,
    username: string,
    name:string,
    email:string,
    role:string,
    enabled:string,
    authorities:authority[]
   
}

export interface authority{
    authority: string
}