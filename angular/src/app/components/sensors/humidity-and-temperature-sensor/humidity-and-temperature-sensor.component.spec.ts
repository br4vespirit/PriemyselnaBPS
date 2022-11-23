import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HumidityAndTemperatureSensorComponent } from './humidity-and-temperature-sensor.component';

describe('HumidityAndTemperatureSensorComponent', () => {
  let component: HumidityAndTemperatureSensorComponent;
  let fixture: ComponentFixture<HumidityAndTemperatureSensorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HumidityAndTemperatureSensorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HumidityAndTemperatureSensorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
