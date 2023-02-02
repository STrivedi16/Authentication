package com.example.authentication.Interface;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface RolePermissionInterface {

	ArrayList<String> getPermissionById(int id);
}
