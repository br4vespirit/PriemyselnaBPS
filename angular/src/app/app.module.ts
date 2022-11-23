import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatButtonModule} from "@angular/material/button";
import {MatCardModule} from "@angular/material/card";
import { WaterSensorComponent } from './components/sensors/water-sensor/water-sensor.component';
import { MotionSensorComponent } from './components/sensors/motion-sensor/motion-sensor.component';
import { SoundSensorComponent } from './components/sensors/sound-sensor/sound-sensor.component';
import { HumidityAndTemperatureSensorComponent } from './components/sensors/humidity-and-temperature-sensor/humidity-and-temperature-sensor.component';
import { AirQualitySensorComponent } from './components/sensors/air-quality-sensor/air-quality-sensor.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    DashboardComponent,
    NavbarComponent,
    WaterSensorComponent,
    MotionSensorComponent,
    SoundSensorComponent,
    HumidityAndTemperatureSensorComponent,
    AirQualitySensorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    MatButtonModule,
    MatCardModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
