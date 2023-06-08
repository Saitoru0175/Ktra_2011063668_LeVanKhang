package com.example.demo6.controller;

import com.example.demo6.entity.nhanvien;
import com.example.demo6.services.NhanvienService;
import com.example.demo6.services.PhongbanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nhanviens")
public class NhanvienController {

    @Autowired
    private NhanvienService nhanvienService;
    @Autowired
    private PhongbanService phongbanService;

    @GetMapping
    public String showAllNhanvien(Model model) {
        List<nhanvien> nhanviens = nhanvienService.getAllNhanvien();
        model.addAttribute("nhanviens", nhanviens);
        return "nhanvien/list";
    }

    @GetMapping({"/delete/{ma_nv}"})
    public String deleteNhanvien(@PathVariable("ma_nv") String ma_nv) {
        this.nhanvienService.deleteNhanvien(ma_nv);
        return "redirect:/nhanviens";
    }

    @GetMapping("/add")
    public String addNhanvienForm(Model model) {
        model.addAttribute("nhanvien", new nhanvien());
        model.addAttribute("phongbans", phongbanService.getAllPhongban());
        return "nhanvien/add";
    }

    @PostMapping("/add")
    public String addNhanvien(@ModelAttribute("nhanvien") @Valid nhanvien nhanvien, BindingResult result, Model model) {
        if(result != null && result.hasErrors()){
            List<String> errors = result.getAllErrors()
                    .stream().map(ObjectError::getDefaultMessage).toList();
            model.addAttribute("errors", errors);
            return "nhanvien/add";
        }
        nhanvienService.addNhanvien(nhanvien);
        return "redirect:/nhanviens";
    }

    @GetMapping({"/edit/{ma_nv}"})
    public String editBookForm(@PathVariable("ma_nv") String ma_nv, Model model) {
        nhanvien nhanvien = this.nhanvienService.getNhanvienByMa(ma_nv);
        model.addAttribute("nhanvien", nhanvien);
        model.addAttribute("phongbans", this.phongbanService.getAllPhongban());
        return "nhanvien/edit";
    }

    @PostMapping({"/edit/{ma_nv}"})
    public String editNhanvien(@PathVariable("ma_nv") String ma_nv, @ModelAttribute("nhanvien") nhanvien nhanvien) {
        nhanvien.setMa_nv(ma_nv);
        this.nhanvienService.updateNhanvien(nhanvien);
        return "redirect:/nhanviens";
    }
}
