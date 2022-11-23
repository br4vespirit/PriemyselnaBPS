import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SoundSensorComponent } from './sound-sensor.component';

describe('SoundSensorComponent', () => {
  let component: SoundSensorComponent;
  let fixture: ComponentFixture<SoundSensorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SoundSensorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SoundSensorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
