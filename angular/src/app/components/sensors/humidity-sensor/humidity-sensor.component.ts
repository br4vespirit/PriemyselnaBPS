import { Component, OnInit } from '@angular/core';
import Chart from 'chart.js/auto';
import { registerables } from 'chart.js';
import {Temperature} from "../../../model/temperature.model";
import {Subscription} from "rxjs";
import {BackendService} from "../../../service/backend.service";
import {Humidity} from "../../../model/humidity.model";
Chart.register(...registerables);

@Component({
  selector: 'app-humidity-sensor',
  templateUrl: './humidity-sensor.component.html',
  styleUrls: ['./humidity-sensor.component.css']
})
export class HumiditySensorComponent implements OnInit {

  humidity: Humidity[] = [];
  humidity_subscription: Subscription = new Subscription();

  constructor(private _client: BackendService) {
    this.humidity_subscription = this._client.fetchHumidity().subscribe(
      data => {
        this.humidity = data
        console.log(this.humidity)

        // getting array with temperature
        this.humidity = this.humidity.reverse();

        // array with indexes (y voord)
        let _labels: String[] = [];
        for (let i = 0; i < this.humidity.length; i++) {
          _labels.push(String(i));
        }

        // array with temperature (x coord)
        let _data: number[] = [];
        for (let i = 0; i < this.humidity.length; i++) {
          _data.push(this.humidity[i].humidity);
        }

        // creating line chart with temperature
        const lineChart = new Chart("lineChart", {
          type: 'line',
          data: {
            labels: _labels,
            datasets: [{
              label: 'Humidity',
              data: _data,
              borderWidth: 3,
              borderColor: "#e36108",
            }]
          },
          options: {
            scales: {
              y: {
                beginAtZero: true,
                ticks: {
                  font: {
                    size: 14
                  }
                },
                min: 0,
                max: 100
              },
              x: {
                ticks: {
                  font: {
                    size: 14
                  }
                }
              }
            }
          }
        });

        // creating bar chart with temperature
        const barChart = new Chart("barChart", {
          type: 'bar',
          data: {
            labels: _labels,
            datasets: [{
              label: 'Humidity',
              data: _data,
              borderWidth: 3,
              borderColor: "#14b4ea",
            }]
          },
          options: {
            scales: {
              y: {
                beginAtZero: true,
                ticks: {
                  font: {
                    size: 14
                  }
                },
                min: 0,
                max: 100
              },
              x: {
                ticks: {
                  font: {
                    size: 14
                  }
                }
              }
            }
          }
        });

      }
    );
  }

  ngOnInit(): void {

  }

  ngOnDestroy(): void {
    this.humidity_subscription.unsubscribe();
  }

}
