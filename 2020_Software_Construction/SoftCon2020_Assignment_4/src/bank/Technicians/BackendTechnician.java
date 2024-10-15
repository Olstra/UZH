package bank.Technicians;

public class BackendTechnician extends Technician {

    public BackendTechnician(String name, String surname) throws IllegalArgumentException {
        super(name, surname);
    }

    public void FixBackEnd(int ID ) {

        if ( this.getID() != ID ) {
            throw new IllegalArgumentException("wrong ID was provided");
        }

        System.out.println("fixed!");
    }

}