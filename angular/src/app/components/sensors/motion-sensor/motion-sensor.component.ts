import {Component, OnInit, ViewChild} from '@angular/core';
import {Subscription} from "rxjs";
import {BackendService} from "../../../service/backend.service";
import {Motion} from "../../../model/motion.model";
import {MotionDto} from "../../../model/motion-dto.model";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";

@Component({
  selector: 'app-motion-sensor',
  templateUrl: './motion-sensor.component.html',
  styleUrls: ['./motion-sensor.component.css']
})
export class MotionSensorComponent implements OnInit {

  motion: Motion[] = [];
  motion_subscription: Subscription = new Subscription();

  motionParsed: MotionDto[] = [];
  dataLoaded = false;

  columns = ["year", "month", "day", "hour", "minute", "second"];

  // @ts-ignore
  dataSource: MatTableDataSource<MotionDto>;
  // @ts-ignore
  @ViewChild('paginator') paginator: MatPaginator;

  constructor(private _client: BackendService) {

  }

  ngOnInit(): void {
    this.motion_subscription = this._client.fetchMotion().subscribe(
      data => {
        this.motion = data;

        // getting array with temperature
        this.motion = this.motion.reverse();

        // transform to motion dto with motion
        this.motionParsed = MotionDto.parse(this.motion);

        this.dataSource = new MatTableDataSource(this.motionParsed);
        this.dataSource.paginator = this.paginator;

        this.dataLoaded = true;
      }
    );
  }

  ngOnDestroy(): void {
    this.motion_subscription.unsubscribe();
  }
}
