import { Component, OnInit } from '@angular/core';
import {Subscription} from "rxjs";
import {BackendService} from "../../../service/backend.service";
import Chart from "chart.js/auto";
import {Water} from "../../../model/water.model";

@Component({
  selector: 'app-water-sensor',
  templateUrl: './water-sensor.component.html',
  styleUrls: ['./water-sensor.component.css']
})
export class WaterSensorComponent implements OnInit {

  water: Water[] = [];
  water_subscription: Subscription = new Subscription();

  constructor(private _client: BackendService) {
    this.water_subscription = this._client.fetchWater().subscribe(
      data => {
        this.water = data

        // getting array with temperature
        this.water = this.water.reverse();

        // array with indexes (y voord)
        let _labels: String[] = ["Watered", "Not watered"];

        // array with temperature (x coord)
        let _data: number[] = [];
        for (let i = 0; i < this.water.length; i++) {
          _data.push(Number(this.water[i].waterPresent));
        }

        let trues: number = _data.filter(Boolean).length;
        let falses: number = _data.length - trues;

        let xValues = [trues, falses]
        const barColors = [
          'rgb(38,210,210)',
          'rgb(140,238,17)',
        ];

        // array with indexes (y coord)
        let _labels1: String[] = [];
        for (let i = 0; i < this.water.length; i++) {
          _labels1.push(String(i));
        }

        // array with temperature (x coord)
        let _data1: number[] = [];
        for (let i = 0; i < this.water.length; i++) {
          _data1.push(Number(this.water[i].waterPresent));
        }

        // creating line chart with temperature
        const lineChart = new Chart("lineChart", {
          type: "doughnut",
          data: {
            labels: _labels,
            datasets: [{
              backgroundColor: barColors,
              data: xValues
            }]
          },
          options: {
            plugins: {
              title: {
                display: true,
                text: 'Watered sensor for 24 last hours',
                padding: {
                  top: 10,
                  bottom: 30
                },
                font: {
                  size: 24
                }
              }
            }
          }
        });

        // creating bar chart with temperature
        const barChart = new Chart("barChart", {
          type: 'bar',
          data: {
            labels: _labels1,
            datasets: [{
              label: 'Water',
              data: _data1,
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
                max: 1
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
    this.water_subscription.unsubscribe();
  }

}
