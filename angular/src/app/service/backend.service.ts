import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  private headers: HttpHeaders = new HttpHeaders({
    "Content-Type": "application/json",
  })

  constructor(private _client: HttpClient) { }

  public fetchTemperature(): Observable<any> {
    return this._client.get("http://localhost:8080/api/v1/pbs/temperature-sensor", {responseType: "json"});
  }

  public fetchHumidity(): Observable<any> {
    return this._client.get("http://localhost:8080/api/v1/pbs/humidity-sensor", {responseType: "json"});
  }

  public fetchMotion(): Observable<any> {
    return this._client.get("http://localhost:8080/api/v1/pbs/motion-sensor", {responseType: "json"});
  }

  public fetchSound(): Observable<any> {
    return this._client.get("http://localhost:8080/api/v1/pbs/sound-sensor", {responseType: "json"});
  }
}
