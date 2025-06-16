package ie.williamswalsh.using_person_set;

import ie.williamswalsh.Person;
import ie.williamswalsh.PersonSet;

class PersonTask implements Runnable{
    private final PersonSet sharedPersonSet;
    private final Person newPerson;

    public PersonTask(PersonSet sharedPersonSet, Person newPerson) {
        this.sharedPersonSet = sharedPersonSet;
        this.newPerson = newPerson;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        sharedPersonSet.addPerson(newPerson);
        System.out.println("" + threadName + ": Added person: " + newPerson);
    }
}