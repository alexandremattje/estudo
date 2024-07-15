import axios from "axios";
// import { parseCookies } from "nookies";

export function getApiClient(ctx = undefined) {
    
    // const { 'pb.token': token } = parseCookies(ctx);

    const api = axios.create({
        baseURL: 'http://localhost:8080',
        timeout: 900000 
    });

    api.interceptors.request.use((config) => {
        // console.log(config,'config-axios');
        return config;
    });

    // if(token) {
    //     api.defaults.headers['Authorization'] = `Bearer ${token}`;
    // }
   

    return api;

}