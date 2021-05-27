import com.emmy.contatos.pessoa.service.PessoaServiceImpl;

@Controller
public class PessoaApiRestController {

 @Autowired
 private PessoaServiceImpl PessoaServiceImpl;
 
 @RequestMapping(value = "/insert", method = RequestMethod.GET)
 public ModelAndView insert() {
        return new ModelAndView("insert", "pessoa", new Pessoa());
 }
 
 @RequestMapping(value = "/insert", method = RequestMethod.POST)
 public String submitInsert(@Valid @ModelAttribute("pessoa")Pessoa pessoa, 
      BindingResult result, ModelMap model) {
        
 if (result.hasErrors()) {
            return "error";
        }
        
 pessoaServiceImpl.insertPessoa(pessoa);
        
        return "redirect:";
 }
 
 @RequestMapping(value = "/delete", method = RequestMethod.GET)
 public ModelAndView delete(Integer id) {
 
 return new ModelAndView("delete", "pessoa", pessoaServiceImpl.getPessoaById(id).get());
 }
 
 @RequestMapping(value = "/delete", method = RequestMethod.POST)
 public String submitDelete(@Valid @ModelAttribute("pessoa")Pessoa pessoa,
      BindingResult result, ModelMap model) {
        
 if (result.hasErrors()) {
            return "error";
        }
 
 pessoaServiceImpl.deletePessoaById(pessoa.getId());
        
        return "redirect:";
 }
 
 @RequestMapping(value = "/update", method = RequestMethod.GET)
 public ModelAndView update(Integer id) {
 
        return new ModelAndView("update", "pessoa", pessoaServiceImpl.getPessoaById(id).get());
 }
 
 @RequestMapping(value = "/update", method = RequestMethod.POST)
 public String submitUpdate(@Valid @ModelAttribute("pessoa")Pessoa pessoa,
      BindingResult result, ModelMap model) {
        
 if (result.hasErrors()) {
            return "error";
        }
 
 pessoaServiceImpl.updatePessoa(pessoa);
        
        return "redirect:";
 }
 
 @RequestMapping(value = "/read", method = RequestMethod.GET)
 public ModelAndView read() {
        
        ModelAndView mav = new ModelAndView("read");
        mav.addObject("pessoa", PessoaServiceImpl.getAllPessoas());
        return mav;
 }
 
 @RequestMapping(value = "/", method = RequestMethod.GET)
 public ModelAndView index() {
        
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("pessoa", PessoaServiceImpl.getAllPessoa());
        return mav;
 }
}