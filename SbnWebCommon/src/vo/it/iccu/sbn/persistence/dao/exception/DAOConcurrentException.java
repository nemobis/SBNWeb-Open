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
package it.iccu.sbn.persistence.dao.exception;


public class DAOConcurrentException extends Exception {

	private static final long serialVersionUID = -3405301346807158073L;

	public DAOConcurrentException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DAOConcurrentException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DAOConcurrentException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DAOConcurrentException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
