/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HandleData;

import java.util.ArrayList;
import ClassConstructor.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author QUÂN BÙI
 */
public class IOfile {

    public static void writeNhanVien(ArrayList<NhanVien> list) {
        try (PrintWriter pw = new PrintWriter(new File("nhanvien.txt"))) {
            for (NhanVien n : list) {
                pw.println(n.getID());
                pw.println(n.getHoTen());
                pw.println(n.getGioiTinh());
                pw.println(n.getQue());
                pw.println(n.getBirthDay());
                pw.println(n.getUser());
                pw.println(n.getPass());
                pw.println(n.getPosition());
                pw.println(n.getActive());
            }
        } catch (Exception e) {
            System.out.println("have an exception");
        }
    }

    public static ArrayList<NhanVien> readNhanVien() {
        ArrayList<NhanVien> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new File("nhanvien.txt"))) {
            while (sc.hasNext()) {
                NhanVien nv = new NhanVien();
                nv.setId(sc.nextLine());
                nv.setHoTen(sc.nextLine());
                nv.setGioiTinh(sc.nextLine());
                nv.setQue(sc.nextLine());
                nv.setBirth(sc.nextLine());
                nv.setUser(sc.nextLine());
                nv.setPass(sc.nextLine());
                nv.setPos(sc.nextLine());
                nv.setActive(sc.nextLine());
                
                list.add(nv);
            }
        } catch (Exception e) {
            System.out.println("Have an exception");
        }
        return list;
    }

    public static void writeClothes(ArrayList<Clothes> list) {
        try (PrintWriter pw = new PrintWriter(new File("sanpham.txt"))) {
            for (Clothes c : list) {
                pw.println(c.getId());
                pw.println(c.getTenSP());
                pw.println(c.getMau());
                pw.println(c.getSize());
                pw.println(c.getGiaBan());
                pw.println(c.getGiaGoc());
                pw.println(Integer.toString(c.getIdDistrict()));
                pw.println(c.getSLHienTai());
                pw.println(c.getIdNhom());
            }
        } catch (Exception e) {
            System.out.println("have an exception");
        }
    }

    public static ArrayList<Clothes> readClothes() {
        ArrayList<Clothes> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new File("sanpham.txt"))) {
            while (sc.hasNext()) {
                Clothes cl = new Clothes();
                cl.setId(Integer.parseInt(sc.nextLine()));
                cl.setTenSp(sc.nextLine());
                cl.setMau(sc.nextLine());
                cl.setSize(sc.nextLine());
                cl.setGiaBan(Integer.parseInt(sc.nextLine()));
                cl.setGiaGoc(Integer.parseInt(sc.nextLine()));
                cl.setArea(Integer.parseInt(sc.nextLine()));
                cl.setSLHienTai(Integer.parseInt(sc.nextLine()));
                cl.setIdNhom(Integer.parseInt(sc.nextLine()));
                list.add(cl);
            }
        } catch (Exception e) {
            System.out.println("Have an exception");
        }
        return list;
    }

    public static void writeHDN(ArrayList<HoaDonNhap> list) {
        try (PrintWriter pw = new PrintWriter(new File("hoadonnhap.txt"))) {
            for (HoaDonNhap hdn : list) {
                pw.println(hdn.getID());
                pw.println(hdn.getDate());
                pw.println(hdn.getNCCID());
                pw.println(hdn.getStaff());
            }
        } catch (Exception e) {
            System.out.println("have an exception");
        }
    }
    public static ArrayList<HoaDonNhap> readHDN() {
        ArrayList<HoaDonNhap> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new File("hoadonnhap.txt"))) {
            while (sc.hasNext()) {
                HoaDonNhap hdn = new HoaDonNhap();
                hdn.setId(sc.nextLine());
                hdn.setDate(sc.nextLine());
                hdn.setNhaCungCap(Integer.parseInt(sc.nextLine()));
                hdn.setNhanVien(sc.nextLine());
                list.add(hdn);
            }
        } catch (Exception e) {
            System.out.println("Have an exception");
        }
        return list;
    }

    public static void writeHDX(ArrayList<HoaDonXuat> list) {
        try (PrintWriter pw = new PrintWriter(new File("hoadonxuat.txt"))) {
            for (HoaDonXuat hdx : list) {
                pw.println(hdx.getID());
                pw.println(hdx.getDate());
                pw.println(Integer.toString(hdx.getCustommerID()));
                pw.println(hdx.getStaff());
            }
        } catch (Exception e) {
            System.out.println("have an exception");
        }
    }

    public static ArrayList<HoaDonXuat> readHDX() {
        ArrayList<HoaDonXuat> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new File("hoadonxuat.txt"))) {
            while (sc.hasNext()) {
                HoaDonXuat hdx = new HoaDonXuat();
                hdx.setId(sc.nextLine());
                hdx.setDate(sc.nextLine());
                hdx.setCustomer(Integer.parseInt(sc.nextLine()));
                hdx.setNhanVien(sc.nextLine());
                list.add(hdx);
            }
        } catch (Exception e) {
            System.out.println("Have an exception");
        }
        return list;
    }

    public static void writeCTDS(ArrayList<CTDS> list) {
        try (PrintWriter pw = new PrintWriter(new File("chitiethoadon.txt"))) {
            for (CTDS ds : list) {
                pw.println(ds.getIdHD());
                pw.println(ds.getIdClothes());
                pw.println(ds.getNumberCount());
            }
        } catch (Exception e) {
            System.out.println("have an exception");
        }
    }

    public static ArrayList<CTDS> readCTDS() {
        ArrayList<CTDS> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new File("chitiethoadon.txt"))) {
            while (sc.hasNext()) {
                CTDS ds = new CTDS();
                ds.setIdHD(sc.nextLine());
                ds.setIdClothes(Integer.parseInt(sc.nextLine()));
                ds.setSoluong(Integer.parseInt(sc.nextLine()));
                list.add(ds);
            }
        } catch (Exception e) {
            System.out.println("Have an exception");
        }
        return list;
    }

    public static void writeGroupClothe(ArrayList<GroupClothes> list) {
        try (PrintWriter pw = new PrintWriter(new File("nhomSP.txt"))) {
            for (GroupClothes n : list) {
                pw.println(n.getID());
                pw.println(n.getName());
            }
        } catch (Exception e) {
            System.out.println("have an exception");
        }
    }

    public static ArrayList<GroupClothes> readGroupClothe() {
        ArrayList<GroupClothes> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new File("nhomSP.txt"))) {
            while (sc.hasNext()) {
                GroupClothes gr = new GroupClothes();
                gr.setID(Integer.parseInt(sc.nextLine()));
                gr.setNameGroup(sc.nextLine());
                list.add(gr);
            }
        } catch (Exception e) {
            System.out.println("Have an exception");
        }
        return list;
    }

    public static void writeArena(ArrayList<Arena> list) {
        try (PrintWriter pw = new PrintWriter(new File("khuvuc.txt"))) {
            for (Arena n : list) {
                pw.println(n.getID());
                pw.println(n.getName());
            }
        } catch (Exception e) {
            System.out.println("have an exception");
        }
    }

    public static ArrayList<Arena> readArena() {
        ArrayList<Arena> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new File("khuvuc.txt"))) {
            while (sc.hasNext()) {
                Arena arena = new Arena();
                arena.setID(Integer.parseInt(sc.nextLine()));
                arena.setName(sc.nextLine());
                list.add(arena);
            }
        } catch (Exception e) {
            System.out.println("Have an exception");
        }
        return list;
    }

    public static void writeCustomer(ArrayList<Customer> list) {
        try (PrintWriter pw = new PrintWriter(new File("khachhang.txt"))) {
            for (Customer c : list) {
                pw.println(c.getID());
                pw.println(c.getName());
                pw.println(c.getPhone());
                pw.println(c.getAddress());
            }
        } catch (Exception e) {
            System.out.println("have an exception");
        }
    }

    public static ArrayList<Customer> readCustomer() {
        ArrayList<Customer> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new File("khachhang.txt"))) {
            while (sc.hasNext()) {
                Customer cus = new Customer();
                cus.setID(Integer.parseInt(sc.nextLine()));
                cus.setName(sc.nextLine());
                cus.setPhone(sc.nextLine());
                cus.setAddress(sc.nextLine());
                list.add(cus);
            }
        } catch (Exception e) {
            System.out.println("Have an exception");
        }
        return list;
    }

    public static void writeNCC(ArrayList<NhaCungCap> list) {
        try (PrintWriter pw = new PrintWriter(new File("nhacungcap.txt"))) {
            for (NhaCungCap c : list) {
                pw.println(c.getID());
                pw.println(c.getName());
                pw.println(c.getPhone());
                pw.println(c.getAddress());
            }
        } catch (Exception e) {
            System.out.println("have an exception");
        }
    }

    public static ArrayList<NhaCungCap> readNCC() {
        ArrayList<NhaCungCap> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new File("nhacungcap.txt"))) {
            while (sc.hasNext()) {
                NhaCungCap cus = new NhaCungCap();
                cus.setID(Integer.parseInt(sc.nextLine()));
                cus.setName(sc.nextLine());
                cus.setPhone(sc.nextLine());
                cus.setAddress(sc.nextLine());
                list.add(cus);
            }
        } catch (Exception e) {
            System.out.println("Have an exception");
        }
        return list;
    }
}
