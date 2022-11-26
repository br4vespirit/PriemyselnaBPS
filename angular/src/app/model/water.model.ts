export class Water {
  id: number;
  waterPresent: boolean;
  dateReceived: Date;

  constructor(id: number, waterPresent: boolean, dateReceived: Date) {
    this.id = id;
    this.waterPresent = waterPresent;
    this.dateReceived = dateReceived;
  }
}
