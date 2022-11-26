export class Temperature {
  id: number;
  temperature: number;
  dateReceived: Date;

  constructor(id: number, temperature: number, dateReceived: Date) {
    this.id = id;
    this.temperature = temperature;
    this.dateReceived = dateReceived;
  }
}
