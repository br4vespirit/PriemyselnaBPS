export class Humidity {
  id: number;
  humidity: number;
  dateReceived: Date;

  constructor(id: number, humidity: number, dateReceived: Date) {
    this.id = id;
    this.humidity = humidity;
    this.dateReceived = dateReceived;
  }
}
