export class Motion {
  id: number;
  dateReceived: Date;

  constructor(id: number, dateReceived: Date) {
    this.id = id;
    this.dateReceived = dateReceived;
  }
}
