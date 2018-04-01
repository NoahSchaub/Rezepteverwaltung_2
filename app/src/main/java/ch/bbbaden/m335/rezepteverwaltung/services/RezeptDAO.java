package ch.bbbaden.m335.rezepteverwaltung.services;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import ch.bbbaden.m335.rezepteverwaltung.objects.Rezept;
import ch.bbbaden.m335.rezepteverwaltung.objects.User;

/**
 * Created by Noah on 02.03.2018.
 */

@Dao
public interface RezeptDAO {
    @Query("SELECT * FROM rezepte")
    List<Rezept> getAllRezepte();

    @Query("SELECT * FROM rezepte WHERE rezeptId IN (:rezeptId)")
    Rezept loadAllRezepteByIds(int rezeptId);

    @Query("SELECT * FROM rezepte WHERE rezeptName LIKE :name LIMIT 1")
    Rezept findByRezepteName(String name);

    @Query("SELECT * FROM rezepte WHERE rezeptAuthor LIKE :name")
    List<Rezept> findByRezepteAuthor(String name);

    @Insert
    void insertAll(Rezept... rezepte);

    @Delete
    void delete(Rezept rezept);

    @Query("DELETE FROM rezepte")
    void deleteAll();


}