import com.emmy.contatos.pessoa.model.pessoa;

@Service("pessoaServiceImpl")
public class PessoaServiceImpl implements PessoaService{
 
    @Autowired private PessoaRepositoty pessoaRepository;
 
    @Override
    public Iterable findAll() {
    return this.pessoaRepository.findAll();
    }
    @Override
    public Pessoa save(Pessoa pessoa) {
    return this.pessoaRepository.save(pessoa);
    }
}