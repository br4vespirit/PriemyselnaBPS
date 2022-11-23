import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AirQualitySensorComponent } from './air-quality-sensor.component';

describe('AirQualitySensorComponent', () => {
  let component: AirQualitySensorComponent;
  let fixture: ComponentFixture<AirQualitySensorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AirQualitySensorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AirQualitySensorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
