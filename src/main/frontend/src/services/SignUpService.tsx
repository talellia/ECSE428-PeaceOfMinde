import {ajax, AjaxResponse} from "rxjs/ajax"
import {Observable} from 'rxjs';

export interface BuyerDto{
    firstName: string;
    lastName: string;
    userName: string;
    password: string;
    email: string;
    residentialAddress: string;
    about_description: string;
    isRegisteredOnline: boolean;
}

const getUrl:Function = (): string =>{
    return "http://localhost:8080";
}

const SignUpService ={
    helloWorld:(): Observable<AjaxResponse < BuyerDto >> =>{
        return ajax.get<BuyerDto>(`${getUrl()}/hello`);
    },
    signUpBuyer:(buyerDto: BuyerDto): Observable<AjaxResponse<BuyerDto>> =>{
        console.log(buyerDto)
        return ajax.post<BuyerDto>(`${getUrl()}/person/buyer/register`, buyerDto);
    }
}

export default SignUpService;