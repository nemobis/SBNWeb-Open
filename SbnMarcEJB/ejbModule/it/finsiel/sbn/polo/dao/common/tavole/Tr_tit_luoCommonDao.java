/*******************************************************************************
 * Copyright (C) 2019 ICCU - Istituto Centrale per il Catalogo Unico
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package it.finsiel.sbn.polo.dao.common.tavole;

import it.finsiel.sbn.exception.InfrastructureException;
import it.finsiel.sbn.polo.dao.vo.Parameter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.hibernate.criterion.Criterion;

/*
DEFAULT<opzionale dipende="XXXtp_luogo"> AND tp_luogo = XXXtp_luogo </opzionale>

 */

public class Tr_tit_luoCommonDao extends TableDao{

	protected boolean kycleslike = false;

    public Tr_tit_luoCommonDao() {
        super();
    }
    public void createCriteria(HashMap opzioni) throws InfrastructureException
    {
        try {
            Class cl = Tr_tit_luoCommonDao.class;//this.getClass();
            Method[] metodi = cl.getDeclaredMethods();
            for(int index =0; index<metodi.length; index++){
                if(metodi[index].getName().startsWith("set")){
                        metodi[index].invoke(this,new Object[] { opzioni});
                    //log.debug(metodi[index].getName());
                }
            }
            super.createCriteria(opzioni);
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new InfrastructureException(e);
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new InfrastructureException(e);
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new InfrastructureException(e);
        }
    }
    public static void main(String[] args) throws Exception{
        Tr_tit_luoCommonDao aut = new Tr_tit_luoCommonDao();
        aut.createCriteria(new HashMap());
        System.exit(0);
    }

    /*
    <opzionale dipende="XXXtp_luogo"> AND tp_luogo = XXXtp_luogo </opzionale>
     */
    public void setTpLuogo(HashMap opzioni) throws Exception {
        Criterion value;
        Parameter param = new Parameter();
        param.setKey("TP_LUOGO");
        param.setValueString(opzioni,Tr_tit_luoCommonDao.XXXtp_luogo);

        if ((value = this.setParameterEq(param)) != null) {
            this.basicCriteria.add(value);
        }
    }
}
