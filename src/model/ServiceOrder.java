package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "service_orders")
public class ServiceOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Tutor tutor;
    @OneToOne
    private Pet pet;
    @ManyToMany
    private List<Service> services;
    @ManyToOne
    private Status status;
    @ManyToOne
    private Employee employee;
    @Version
    private long version;

    public ServiceOrder() {
    }

    public ServiceOrder(Tutor tutor, Pet pet, Status status, Employee employee) {
        this.tutor = tutor;
        this.pet = pet;
        this.services = new ArrayList<Service>();
        this.status = status;
        this.employee = employee;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Pet getPet() {
        return pet;
    }
    
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public List<Service> getServices() {
        return services;
    }

    public void addService(Service service) {
        services.add(service);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String _employee = "employee cpf=" + employee.getDocument() + ", ";
        String _tutor = "tutor cpf=" + tutor.getDocument() + ", ";
        String _pet = "pet=" + pet.getName() + ", ";
        String _services = "services=" + services + ", ";
        String _status = "status=" + status.getName();
        return "ServiceOrder [" + _employee + _tutor + _pet + _services + _status + "]";
    }

	public void setObservation(String string) {
		// Auto-generated method stub
		
	}

}
