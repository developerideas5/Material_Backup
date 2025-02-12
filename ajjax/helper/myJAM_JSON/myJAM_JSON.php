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

class myJAM_JSON
{
  protected $data = NULL;
  //o-------------------------------------------------------------------------------o
  public function __construct($str = NULL)
  //o-------------------------------------------------------------------------------o
  {
    $this->data = array();
    if(!empty($str))
    {
      $this->fromBase64($str);
    }
  }
  //o-------------------------------------------------------------------------------o
  public function __get($name)
  //o-------------------------------------------------------------------------------o
  {
    if(isset($this->data[$name]))
    {
      return $this->data[$name];
    }
    return NULL;
  }
  //o-------------------------------------------------------------------------------o
  public function __set($name, $val)
  //o-------------------------------------------------------------------------------o
  {
    $this->data[$name] = $val;
    return $val;
  }
  //o-------------------------------------------------------------------------------o
  public function fromBase64($str)
  //o-------------------------------------------------------------------------------o
  {
    if(!$this->is_base64($str))
    {
      throw new Exception('String is not strict base64 encoded!');
    }
    $tmp = base64_decode($str);
    $this->fromJSON($tmp);
    return $this;
  }
  //o-------------------------------------------------------------------------------o
  public function fromJSON($str)
  //o-------------------------------------------------------------------------------o
  {
    $tmp = json_decode($str, true);
    if($tmp == NULL)
    {
      throw new Exception('Cannot decode JSON string');
    }
    $this->fromArray($tmp);
    return $this;
  }
  //o-------------------------------------------------------------------------------o
  public function fromArray($arr)
  //o-------------------------------------------------------------------------------o
  {
    if(!is_array($arr))
    {
      throw new Exception('Not a valid array');
    }
    $this->data = array_merge_recursive($this->data, $arr);
    return $this;
  }
  //o-------------------------------------------------------------------------------o
  public function getAssoc()
  //o-------------------------------------------------------------------------------o
  {
    return $this->data;
  }
  //o-------------------------------------------------------------------------------o
  public function toJSON()
  //o-------------------------------------------------------------------------------o
  {
    return json_encode($this->data);
  }
  //o-------------------------------------------------------------------------------o
  public function toBase64()
  //o-------------------------------------------------------------------------------o
  {
    return base64_encode($this->toJSON());
  }
  //o-------------------------------------------------------------------------------o
  private function is_base64($str)
  //o-------------------------------------------------------------------------------o
  {
    if (preg_match('%^[a-zA-Z0-9/+]*={0,2}$%', $str))
    {
      return TRUE;
    }
    else
    {
      return FALSE;
    }
  }
}
