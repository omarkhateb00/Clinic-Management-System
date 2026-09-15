public class Doctor implements Nodeable {
    private String DID;
    private Queue<Patient> wd;

    public Doctor(String id){
        DID = id;
        wd = new Queue<>();
    }
    @Override
    public String getKey(){return DID;}

    @Override
    public int getValue(){
        return 0;
    }

    public void enterPatient(Patient p){
        wd.insert(p);
        p.setPlace(wd.getLastNode());
    }
    public Patient nextPatient() {
            return wd.peek();
    }
    public Patient nextPatientLeave(){return wd.remove();}
    public int waitingNum(){return wd.getSize();}

}
