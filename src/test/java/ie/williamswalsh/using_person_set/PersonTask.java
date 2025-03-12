package ie.williamswalsh.using_person_set;

class PersonTask implements Runnable{
    @Override
    public void run()
    {
        String threadName = Thread.currentThread().getName();
        System.out.println("" + threadName + ": Running Person Task");
    }
}