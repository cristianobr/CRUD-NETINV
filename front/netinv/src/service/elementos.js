import { http } from './config'

export default	{

	salvar:(elemento)=>{
		return http.post('elemento',elemento);
  },
    
	atualizar:(elemento)=>{
		return http.put('elemento',elemento);
  },

  listar:()=>{
		return http.get('elementos')
  },
    
	apagar:(elemento)=>{
		return http.delete('elemento', { data: elemento })
	}
}