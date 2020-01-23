public class StartFlow {

    public void Start (){
        Flows flow1 = new Flows("Поток А");
        Flows flow2 = new Flows("Поток Б");
        flow1.start();
        flow2.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if (!flow1.isAlive()){
                        if (flow2.isAlive()){
                            flow1.WriteToFile(flow1.getName() + " - выиграл\n");
                            break;
                        }else{
                            flow1.WriteToFile(flow1.getName() + " - проиграл\n");
                            break;
                        }
                    }

                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if (!flow2.isAlive()){
                        if (flow1.isAlive()){
                            flow1.WriteToFile(flow2.getName() + " - выиграл\n");
                            break;
                        }else{
                            flow1.WriteToFile(flow2.getName() + " - проиграл\n");
                            break;
                        }
                    }

                }
            }
        }).start();
    }
}
