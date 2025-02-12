<?php
/*
   _                          _____     _       ____    ____      __ _
  / /                        |_   _|   / \     |_   \  /   _|    / /\ \
 / /  _ .--..--.    _   __     | |    / _ \      |   \/   |     / /  \ \
< <  [ `.-. .-. |  [ \ [  ]_   | |   / ___ \     | |\  /| |    / /    > >
 \ \  | | | | | |   \ '/ /| |__' | _/ /   \ \_  _| |_\/_| |_  / /    / /
  \_\[___||__||__][\_:  / `.____.'|____| |____||_____||_____|/_/    /_/ Community Edition
                   \__.' o---------------------------------------------------------------
                         |
                         o--------o Project Coordinator, CTO: Dr. rer. nat. Stephan Raub
                                  o B.Sc. Ingo Breuer
                                  o Michael Schlapa
                                  o Dennis-Bendert Schramm (retired)
                                  o Marcus Ihde-Meister
                                  o Christoph Gierling (retired)

Copyright (C) 2010,2011 The <myJAM/> Team, Heinrich-Heine-University Duesseldorf, Germany.

https://sourceforge.net/projects/myjam

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307,
USA.
*/

require_once(_FULLPATH.'/helper/myJAM_forms/myJAM_Form_Element_Abstract.php');
class myJAM_Form_Element_Hidden extends myJAM_Form_Element_Abstract
{
  private $el_val = NULL;
  //o-------------------------------------------------------------------------------o
  public function __construct($name, $val = NULL)
  //o-------------------------------------------------------------------------------o
  {
    parent::__construct($name);
    $this->setValue($val);
  }
  //o-------------------------------------------------------------------------------o
  public function setValue($val = NULL)
  //o-------------------------------------------------------------------------------o
  {
    if(!empty($val))
    {
      $this->el_val = $val;
    }
  }
  //o-------------------------------------------------------------------------------o
  public function render()
  //o-------------------------------------------------------------------------------o
  {
    $out = '<input type="hidden"'
                .' name="'.$this->el_name.'"'
                .' id="'.$this->el_name.'"';
    if(!empty($this->el_val))
    {
      $out .= ' value="'.$this->el_val.'"';
    }
    $out .= '/>';
    return $out;
  }
}
