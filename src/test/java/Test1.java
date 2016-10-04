import com.atfuture.action.SpecialtyAction;
import com.atfuture.domain.Specialty;

public class Test1 {
	public static void main(String args){
		SpecialtyAction as=new SpecialtyAction();
		Specialty sp=new Specialty();
		sp.setSpec_name("test1");
		as.setSpecialty(sp);
		as.add();
	}
}