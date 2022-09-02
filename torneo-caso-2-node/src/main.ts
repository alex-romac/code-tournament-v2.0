import { NestFactory } from '@nestjs/core';
import { DocumentBuilder, SwaggerModule } from '@nestjs/swagger';
import { AppModule } from './app.module';
async function bootstrap() {
  const app = await NestFactory.create(AppModule);
  app.setGlobalPrefix('api/torneo');
  const options = new DocumentBuilder()
    .setTitle('Torneo caso 2')
    .setDescription('Micro torneo caso 2')
    .setVersion('1.0.0')
    .build();
  const document = SwaggerModule.createDocument(app, options, {});
  SwaggerModule.setup('documentation', app, document);
  app.enableCors();
  await app.listen(3000);
}
bootstrap();
