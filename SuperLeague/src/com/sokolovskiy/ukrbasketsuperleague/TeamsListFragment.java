package com.sokolovskiy.ukrbasketsuperleague;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class TeamsListFragment extends ListFragment {
	
	final String[] LIST_OF_TEAMS = new String[]	{ 
    		"Киев", "Одесса", "Донецк", "Азовмаш", "Говерла", "Будивельник", "Химик", 
    		"Черкасские мавпы", "Ферро-ЗНТУ", "Крывбассбаскет", "Галичина", "Днепр", "Днепр-Азот", "Николаев"};
    final String[] TEAM_DETAILS = new String[] {
    		"Название команды: БК\"КИЕВ\"\n Город: Киев\n Арена: Меридиан\n Сайт команды: http://www.bckiev.com.ua\n Главный тренер: Ренато Паскуали\n",
    		"Название команды: БК\"ОДЕССА\"\n Город: Одесса\n Арена: СК Краян\n Сайт команды: http://www.bcodessa.ua\n Главный тренер: Олег Юшкин\n",
    		"Название команды: БК\"ДОНЕЦК\"\n Город: Донецк\n Арена: ПС Дружба\n Сайт команды: http://www.bc.donetsk.ua\n Главный тренер: Алексей Ефимов\n",
    		"Название команды: БК\"АЗОВМАШ\"\n Город: Мариуполь\n Арена: ПС Азовмаш\n Сайт команды: http://www.bcazovmash.com.ua\n Главный тренер: Сергей Завалин\n",
    		"Название команды: БК\"ГОВЕРЛА\"\n Город: Ивано-Франковск\n Арена: Манеж КФВ\n Сайт команды: http://www.bcgoverla.if.ua\n Главный тренер: Евгений Мурзин\n",
    		"Название команды: БК\"БУДИВЕЛЬНИК\"\n Город: Киев\n Арена: Дворец Спорта\n Сайт команды: http://www.budivelnyk.ua\n Главный тренер: Айнарас Багатскис\n",
    		"Название команды: БК\"ХИМИК\"\n Город: Южный\n Арена: ФСК Олимп\n Сайт команды: http://www.bc.khimik.com.ua\n Главный тренер: Звездан Митрович\n",
    		"Название команды: БК\"ЧЕРКАССКИЕ МАВПЫ\"\n Город: Черкассы\n Арена: ПС Будивельник\n Сайт команды: http://www.mavpabasket.com\n Главный тренер:Йовица Арсич\n",
    		"Название команды: БК\"ФЕРРО-ЗНТУ\"\n Город: Запорожье\n Арена: ЗАС\n Сайт команды: http://www.bcferro.com.ua\n Главный тренер: Кирилл Большаков\n",
    		"Название команды: БК\"КРЫВБАССБАСКЕТ\"\n Город: Кривой Рог\n Арена: СК КТУ\n Сайт команды: http://www.krivbasbasket.com\n Главный тренер: Карлис Мужниекс\n",
    		"Название команды: БК\"ГАЛИЧИНА\"\n Город: Львов\n Арена: ПС Галичина\n Сайт команды: http://www.bcpg.lviv.ua\n Главный тренер: Желько Лукаич\n",
    		"Название команды: БК\"ДНЕПР\"\n Город: Днепропетровск\n Арена: ПС Метеор\n Сайт команды: http://www.dnipro.ua\n Главный тренер: Вальдемарас Хомичус\n",
    		"Название команды: БК\"ДНЕПР-АЗОТ\"\n Город: Днепродзержинск\n Арена: Дворец тенниса\n Сайт команды: http://www.bcazot.com\n Главный тренер: Аудрюс Пракурайтис\n",
    		"Название команды: БК\"НИКОЛАЕВ\"\n Город: Николаев\n Арена: -\n Сайт команды: http://www.mbc.mk.ua\n Главный тренер: Агрис Гальваноскис\n"	    		    		
    };

	 @Override
	  public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);  
	    //Arrays.sort(LIST_OF_TEAMS);
	    setListAdapter(new TeamsArrayAdapter(getActivity(), LIST_OF_TEAMS));
	    //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
	    //    R.layout.list_of_teams, R.id.label, LIST_OF_TEAMS);	   
	    //setListAdapter(adapter);
	  }

	  @Override
	  public void onListItemClick(ListView parent, View view, int position, long id) {
		  String teamName = parent.getItemAtPosition(position).toString();
		  String teamDetails = TEAM_DETAILS[position];
			startDetailsActivityNeeded(teamName,teamDetails);
	  }
	  
	  private void startDetailsActivityNeeded(String teamName, String teamDetails) {
			TeamDetailsFragment td = (TeamDetailsFragment) getActivity()
					.getFragmentManager().findFragmentById(R.id.teams_details_fragment);
			if (td == null || !td.isInLayout()) {
				Intent intent = new Intent(getActivity(),
						TeamDetailsActivity.class);
				intent.putExtra("teamName", teamName);
				intent.putExtra("teamDetails", teamDetails);
				startActivity(intent);
			} else {
				TextView tv = (TextView) td.getView().findViewById(R.id.tv);
				tv.setText(teamDetails);
				//tv.setText(teamName);
				//WebView webView = (WebView) td.getView().findViewById(R.id.webView1);
				//webView.getSettings().setJavaScriptEnabled(true);
				//webView.loadUrl("http://www.superleague.ua/club/4008.htm");
			}

		}  
	
}