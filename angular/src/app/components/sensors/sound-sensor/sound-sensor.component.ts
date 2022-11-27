import {Component, OnInit, ViewChild} from '@angular/core';
import {Subscription} from "rxjs";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {BackendService} from "../../../service/backend.service";
import {Sound} from "../../../model/sound.model";
import {SoundDto} from "../../../model/sound-dto.model";

@Component({
  selector: 'app-sound-sensor',
  templateUrl: './sound-sensor.component.html',
  styleUrls: ['./sound-sensor.component.css']
})
export class SoundSensorComponent implements OnInit {

  sound: Sound[] = [];
  sound_subscription: Subscription = new Subscription();

  soundParsed: SoundDto[] = [];
  dataLoaded = false;

  columns = ["year", "month", "day", "hour", "minute", "second"];

  // @ts-ignore
  dataSource: MatTableDataSource<SoundDto>;
  // @ts-ignore
  @ViewChild('paginator') paginator: MatPaginator;

  constructor(private _client: BackendService) {

  }

  ngOnInit(): void {
    this.sound_subscription = this._client.fetchSound().subscribe(
      data => {
        this.sound = data;

        // getting array with temperature
        this.sound = this.sound.reverse();

        // transform to motion dto with motion
        this.soundParsed = SoundDto.parse(this.sound);

        this.dataSource = new MatTableDataSource(this.soundParsed);
        this.dataSource.paginator = this.paginator;

        this.dataLoaded = true;
      }
    );
  }

  ngOnDestroy(): void {
    this.sound_subscription.unsubscribe();
  }
}
