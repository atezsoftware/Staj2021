import {Entity, model, property} from '@loopback/repository';

@model()
export class FirmaKarti extends Entity {
  @property({
    type: 'number',
    id: true,
    generated: true,
  })
  id?: number;

  @property({
    type: 'string',
    required: true,
  })
  FirmaKodu: string;

  @property({
    type: 'string',
    required: true,
  })
  FirmaUnvani: string;


  constructor(data?: Partial<FirmaKarti>) {
    super(data);
  }
}

export interface FirmaKartiRelations {
  // describe navigational properties here
}

export type FirmaKartiWithRelations = FirmaKarti & FirmaKartiRelations;
