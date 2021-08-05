import {inject} from '@loopback/core';
import {DefaultCrudRepository} from '@loopback/repository';
import {DbDataSource} from '../datasources';
import {FirmaKarti, FirmaKartiRelations} from '../models';

export class FirmaKartiRepository extends DefaultCrudRepository<
  FirmaKarti,
  typeof FirmaKarti.prototype.id,
  FirmaKartiRelations
> {
  constructor(
    @inject('datasources.db') dataSource: DbDataSource,
  ) {
    super(FirmaKarti, dataSource);
  }
}
