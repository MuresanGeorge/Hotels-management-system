import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {share} from 'rxjs/operators';


const baseUrl: string = 'http://localhost:8081';

@Injectable()
export class HttpService {
  private httpClient: HttpClient;

  constructor(httpClient: HttpClient) {
    this.httpClient = httpClient;
  }

  public get(url): Observable<any> {
    return this.httpClient.get(`${baseUrl}${url}`);
  }

  public post(url, data): Observable<any> {
    return this.httpClient.post(`${baseUrl}${url}`, data);
  }

  public delete(url, data): Observable<any> {
    return this.httpClient.delete(`${baseUrl}${url}`, data);
  }

  public put(url, data): Observable<any> {
    return this.httpClient.put(`${baseUrl}${url}`, data);
  }
}
