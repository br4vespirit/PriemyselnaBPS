import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {AboutComponent} from "./components/about/about.component";
import {DashboardComponent} from "./components/dashboard/dashboard.component";
import {WaterSensorComponent} from "./components/sensors/water-sensor/water-sensor.component";
import {MotionSensorComponent} from "./components/sensors/motion-sensor/motion-sensor.component";
import {SoundSensorComponent} from "./components/sensors/sound-sensor/sound-sensor.component";
import {
  HumidityAndTemperatureSensorComponent
} from "./components/sensors/humidity-and-temperature-sensor/humidity-and-temperature-sensor.component";
import {AirQualitySensorComponent} from "./components/sensors/air-quality-sensor/air-quality-sensor.component";

const routes: Routes = [
  {
    path: "",
    redirectTo: "/home",
    pathMatch: "full"
  },
  {
    path: "home",
    component: HomeComponent
  },
  {
    path: "about",
    component: AboutComponent
  },
  {
    path: "dashboard",
    component: DashboardComponent
  },
  {
    path: "dashboard/water-sensor",
    component: WaterSensorComponent
  },
  {
    path: "dashboard/motion-sensor",
    component: MotionSensorComponent
  },
  {
    path: "dashboard/sound-sensor",
    component: SoundSensorComponent
  },
  {
    path: "dashboard/temperature-and-humidity-sensor",
    component: HumidityAndTemperatureSensorComponent
  },
  {
    path: "dashboard/air-quality-sensor",
    component: AirQualitySensorComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
