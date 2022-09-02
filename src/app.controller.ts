import { Body, Controller, Get, Param, ParseIntPipe } from '@nestjs/common';
import { AppService } from './app.service';
import { Simulate } from './simulate';

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get(':capital')
  async simulate(@Param('capital', ParseIntPipe) capital: number) {
    return this.appService.simulateWithValue(capital);
  }

  @Get('with-days/:capital/:days')
  async simulateWithDays(
    @Param('capital', ParseIntPipe) value: number,
    @Param('days', ParseIntPipe) days: number,
  ) {
    return this.appService.calculateWithDays({ value, days } as Simulate);
  }
}
