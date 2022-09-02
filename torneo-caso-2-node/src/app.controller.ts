import { Controller, Get, Param, ParseIntPipe } from '@nestjs/common';
import { AppService } from './app.service';
import { TableAmortization } from './models/table-amortization';

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get(':capital/:years/:paysYears/:rate')
  tableAmortization(
    @Param('capital', ParseIntPipe) capital: number,
    @Param('years', ParseIntPipe) years: number,
    @Param('paysYears', ParseIntPipe) paysYears: number,
    @Param('rate', ParseIntPipe) rate: number,
  ) {
    if (paysYears <= 12) {
      return 'Ingresa un plazo mayor o igual a 12';
    }
    if (years <= 1) {
      return 'Ingresa un plazo mayor o igual a 1';
    }
    return this.appService.calculateTableAmortization({
      capital,
      years,
      paysYears,
      rate,
    } as TableAmortization);
  }
}
