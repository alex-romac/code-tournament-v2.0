import { Injectable } from '@nestjs/common';
import { TableAmortization } from './models/table-amortization';

@Injectable()
export class AppService {
  private tableAmortization = {
    numberOfCuotes: 1,
    interestPeriodic: 0,
    capitalAmortized: 0,
    payCuotes: 0,
    saldo: 0,
  };

  calculateTableAmortization(data: TableAmortization) {
    const interestPeriodic = this.calculateInterestPeriodid(
      data.rate,
      data.paysYears,
    );
    const numberOfCuotes = this.calculateNumberOfCuotes(
      data.years,
      data.paysYears,
    );
    const capitalAmortized = this.calculateCapitalAmortized(
      data.capital,
      numberOfCuotes,
    );
    const dataTable: any[] = [];
    for (let i = 0; i <= numberOfCuotes; i++) {
      this.tableAmortization.numberOfCuotes = i + 1;
      const saldo =
        i === 0
          ? data.capital
          : this.calculateSaldo(capitalAmortized * i, data.capital);
      this.tableAmortization.saldo = saldo;

      this.tableAmortization.interestPeriodic = this.calculateInteres(
        saldo,
        interestPeriodic,
      );
      this.tableAmortization.capitalAmortized = capitalAmortized;
      this.tableAmortization.payCuotes = this.calculatePayCuotes(
        this.tableAmortization.interestPeriodic,
        capitalAmortized,
      );
      console.log(this.tableAmortization);
      dataTable.push({ ...this.tableAmortization });
    }
    return dataTable;
  }

  calculateInterestPeriodid(rate: number, paysYears: number) {
    const result = rate / paysYears;
    return this.formatDecimal(result);
  }

  calculateNumberOfCuotes(years: number, paysYears: number) {
    const result = years * paysYears;
    return this.formatDecimal(result);
  }

  calculateInteres(capital: number, interesPeriodic: number) {
    const result = (capital * interesPeriodic) / 100;
    return this.formatDecimal(result);
  }

  calculateCapitalAmortized(capital: number, numberOfCuotes: number) {
    const result = capital / numberOfCuotes;
    return this.formatDecimal(result);
  }

  calculatePayCuotes(interesPeriodic: number, capitalAmortized: number) {
    const result = interesPeriodic + capitalAmortized;
    return this.formatDecimal(result);
  }

  calculateSaldo(capitalAmortized: number, capital: number) {
    const result = capital - capitalAmortized;
    return this.formatDecimal(result);
  }

  formatDecimal(value: number) {
    return Number(value.toFixed(2));
  }
}
