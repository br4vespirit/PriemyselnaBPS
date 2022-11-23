import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WaterSensorComponent } from './water-sensor.component';

describe('WaterSensorComponent', () => {
  let component: WaterSensorComponent;
  let fixture: ComponentFixture<WaterSensorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WaterSensorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WaterSensorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
