package com.example.jdbc;

public class DeptDAOTest {
    public static void main(String[] args) {

//         insert
        DeptDTO deptDTO1 = new DeptDTO(110, "lion", "대구");
        if (DeptDAO.addDept(deptDTO1)) {
            System.out.println("success");
        } else {
            System.out.println("failed");
        }

        // update
        DeptDTO deptDTO2 = new DeptDTO(100, "lion22", "분당");
        if (DeptDAO.updateDept(deptDTO2)) {
            System.out.println("success");
        } else {
            System.out.println("failed");
        }

        // delete

    }
}
