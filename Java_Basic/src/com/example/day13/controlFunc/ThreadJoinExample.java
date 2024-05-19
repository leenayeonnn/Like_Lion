package com.example.day13.controlFunc;

public class ThreadJoinExample {
    static class TaskThread extends Thread {
        private String taskName;

        public TaskThread(String taskName) {
            this.taskName = taskName;
        }

        public void run() {
            System.out.println(taskName + " 작업 시작");
            try {
                Thread.sleep(2000); // 2초 동안 스레드 일시 정지 (작업 시뮬레이션)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(taskName + " 작업 완료");
        }
    }

    public static void main(String[] args) {
        TaskThread task1 = new TaskThread("작업 1");
        TaskThread task2 = new TaskThread("작업 2");
        task1.start();
        task2.start();
        try {
            System.out.println("모든 작업의 완료를 기다립니다.");
            task1.join(); // task1의 완료를 기다림
            task2.join(); // task2의 완료를 기다림
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("모든 작업이 완료되었습니다.");
    }
}