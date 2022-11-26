export class Sound {
  id: number;
  value: number;
  dateReceived: Date;

  constructor(id: number, value: number, dateReceived: Date) {
    this.id = id;
    this.value = value
    this.dateReceived = dateReceived;
  }
}
