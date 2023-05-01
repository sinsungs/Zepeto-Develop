import { HttpService, HttpResponse, HttpHeader, HttpBodyType } from "ZEPETO.Multiplay.HttpService";

export default class Request {
    RequestUserId(name : String) {
    // const url: string = "http://ec2-3-34-48-237.ap-northeast-2.compute.amazonaws.com/index.php";
    const url: string = "http://localhost:8080/api/zepeto";

    const headers:HttpHeader = {
        'Content-Type': 'application/json',
        // 'Accept': '*/*',
        // // 'Content-Length': 0
    };

    const body:HttpBodyType = {
        "name": name,
        "challenge": "miracle morning",
    };

    HttpService.postAsync(url, body, headers).then(
       
        (res: HttpResponse) => {
            
            console.log(`HTTP Result: ${JSON.stringify(res)}`);
        });
    }


}