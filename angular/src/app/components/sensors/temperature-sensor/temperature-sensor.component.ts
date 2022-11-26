import { Component, OnInit } from '@angular/core';
import {Temperature} from "../../../model/temperature.model";
import {BackendService} from "../../../service/backend.service";
import {Subscription} from "rxjs";
import Chart from "chart.js/auto";

@Component({
  selector: 'app-temperature-sensor',
  templateUrl: './temperature-sensor.component.html',
  styleUrls: ['./temperature-sensor.component.css']
})
export class TemperatureSensorComponent implements OnInit {

  temperatures: Temperature[] = [];
  temperature_subscription: Subscription = new Subscription();

  constructor(private _client: BackendService) {
    this.temperature_subscription = this._client.fetchTemperature().subscribe(
      data => {
        this.temperatures = data
        console.log(this.temperatures)

        // getting array with temperature
        this.temperatures = this.temperatures.reverse();

        // array with indexes (y voord)
        let _labels: String[] = [];
        for (let i = 0; i < this.temperatures.length; i++) {
          _labels.push(String(i));
        }

        // array with temperature (x coord)
        let _data: number[] = [];
        for (let i = 0; i < this.temperatures.length; i++) {
          _data.push(this.temperatures[i].temperature);
        }

        // creating line chart with temperature
        const lineChart = new Chart("lineChart", {
          type: 'line',
          data: {
            labels: _labels,
            datasets: [{
              label: 'Temperature',
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
                }
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
              label: 'Temperature',
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
                }
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
    this.temperature_subscription.unsubscribe();
  }

}
