import {
  Count,
  CountSchema,
  Filter,
  FilterExcludingWhere,
  repository,
  Where,
} from '@loopback/repository';
import {
  del,
  get,
  getModelSchemaRef,
  param,
  patch,
  post,
  put,
  requestBody,
  response,
} from '@loopback/rest';
import {FirmaKarti} from '../models';
import {FirmaKartiRepository} from '../repositories';

export class FirmaKartiController {
  constructor(
    @repository(FirmaKartiRepository)
    public firmaKartiRepository: FirmaKartiRepository,
  ) {}

  @post('/firmalar')
  @response(200, {
    description: 'Yeni Firma Karti olusturmak icin kullanin',
    content: {'application/json': {schema: getModelSchemaRef(FirmaKarti)}},
  })
  async create(
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(FirmaKarti, {
            title: 'NewFirmaKarti',
            exclude: ['id'],
          }),
        },
      },
    })
    firmaKarti: Omit<FirmaKarti, 'id'>,
  ): Promise<FirmaKarti> {
    return this.firmaKartiRepository.create(firmaKarti);
  }

  @get('/firmalar/count')
  @response(200, {
    description: 'FirmaKarti model count',
    content: {'application/json': {schema: CountSchema}},
  })
  async count(
    @param.where(FirmaKarti) where?: Where<FirmaKarti>,
  ): Promise<Count> {
    return this.firmaKartiRepository.count(where);
  }

  @get('/firmalar')
  @response(200, {
    description: 'Array of FirmaKarti model instances',
    content: {
      'application/json': {
        schema: {
          type: 'array',
          items: getModelSchemaRef(FirmaKarti, {includeRelations: true}),
        },
      },
    },
  })
  async find(
    @param.filter(FirmaKarti) filter?: Filter<FirmaKarti>,
  ): Promise<FirmaKarti[]> {
    return this.firmaKartiRepository.find(filter);
  }

  @patch('/firmalar')
  @response(200, {
    description: 'FirmaKarti PATCH success count',
    content: {'application/json': {schema: CountSchema}},
  })
  async updateAll(
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(FirmaKarti, {partial: true}),
        },
      },
    })
    firmaKarti: FirmaKarti,
    @param.where(FirmaKarti) where?: Where<FirmaKarti>,
  ): Promise<Count> {
    return this.firmaKartiRepository.updateAll(firmaKarti, where);
  }

  @get('/firmalar/{id}')
  @response(200, {
    description: 'FirmaKarti model instance',
    content: {
      'application/json': {
        schema: getModelSchemaRef(FirmaKarti, {includeRelations: true}),
      },
    },
  })
  async findById(
    @param.path.number('id') id: number,
    @param.filter(FirmaKarti, {exclude: 'where'})
    filter?: FilterExcludingWhere<FirmaKarti>,
  ): Promise<FirmaKarti> {
    return this.firmaKartiRepository.findById(id, filter);
  }

  @patch('/firmalar/{id}')
  @response(204, {
    description: 'FirmaKarti PATCH success',
  })
  async updateById(
    @param.path.number('id') id: number,
    @requestBody({
      content: {
        'application/json': {
          schema: getModelSchemaRef(FirmaKarti, {partial: true}),
        },
      },
    })
    firmaKarti: FirmaKarti,
  ): Promise<void> {
    await this.firmaKartiRepository.updateById(id, firmaKarti);
  }

  @put('/firmalar/{id}')
  @response(204, {
    description: 'FirmaKarti PUT success',
  })
  async replaceById(
    @param.path.number('id') id: number,
    @requestBody() firmaKarti: FirmaKarti,
  ): Promise<void> {
    await this.firmaKartiRepository.replaceById(id, firmaKarti);
  }

  @del('/firmalar/{id}')
  @response(204, {
    description: 'FirmaKarti DELETE success',
  })
  async deleteById(@param.path.number('id') id: number): Promise<void> {
    await this.firmaKartiRepository.deleteById(id);
  }
}
