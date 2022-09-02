import { Injectable } from '@nestjs/common';
import { Simulate } from './simulate';

@Injectable()
export class AppService {
  private simulateData = [
    { days: 30, interest: 2, interstEar: 0, total: 0 },
    { days: 60, interest: 2.2, interstEar: 0, total: 0 },
    { days: 90, interest: 2.4, interstEar: 0, total: 0 },
    { days: 120, interest: 2.6, interstEar: 0, total: 0 },
    { days: 1800, interest: 2.8, interstEar: 0, total: 0 },
    { days: 240, interest: 3, interstEar: 0, total: 0 },
    { days: 300, interest: 3.2, interstEar: 0, total: 0 },
    { days: 360, interest: 3.4, interstEar: 0, total: 0 },
  ];

  private simulateWithDays = {
    days: 0,
    interest: 2.2,
    interstEar: 0,
    total: 0,
  };
  simulateWithValue(value: number) {
    const dataComplete = this.simulateData.map((data) => {
      data.interest = this.calculateInterest(value, data.days, data.interest);
      data.total = this.calculateTotal(value, data.interest);
      return data;
    });
    console.log(dataComplete);
    return dataComplete;
  }

  calculateWithDays(simulate: Simulate) {
    this.simulateWithDays.days = simulate.days;
    this.simulateWithDays.interstEar = this.calculateInterest(
      simulate.value,
      simulate.days,
      this.simulateWithDays.interest,
    );
    this.simulateWithDays.total = this.calculateTotal(
      simulate.value,
      this.simulateWithDays.interstEar,
    );
    console.log(this.simulateWithDays);
    return this.simulateWithDays;
  }

  calculateInterest(capital: number, days: number, interest: number) {
    return Number(Number(capital * ((days * interest) / 100 / 360)).toFixed(2));
  }

  calculateTotal(capital: number, interestEar: number) {
    return capital + interestEar;
  }
}
