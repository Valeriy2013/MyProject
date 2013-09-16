package com.sokolovskiy.mainpackage;

import com.sokolovskiy.activities.TeamDetailsActivity;
import com.sokolovskiy.ukrbasketsuperleague.R;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class TeamsListFragment extends ListFragment {
	
	final String[] LIST_OF_TEAMS = new String[]	{ 
    		"Киев", "Оде�?�?а", "Донецк", "�?зовмаш", "Говерла", "Будивельник", "Химик", 
    		"Черка�?�?кие мавпы", "Ферро-З�?ТУ", "Крывба�?�?ба�?кет", "Галичина", "Днепр", "Днепр-�?зот", "�?иколаев"};
    final String[] TEAM_DETAILS = new String[] {
    		"�?азвание команды: БК\"КИЕВ\"\n Город: Киев\n �?рена: Меридиан\n Сайт команды: http://www.bckiev.com.ua\n Главный тренер: Ренато Па�?куали\n",
    		"�?азвание команды: БК\"ОДЕСС�?\"\n Город: Оде�?�?а\n �?рена: СК Кра�?н\n Сайт команды: http://www.bcodessa.ua\n Главный тренер: Олег Юшкин\n",
    		"�?азвание команды: БК\"ДО�?ЕЦК\"\n Город: Донецк\n �?рена: ПС Дружба\n Сайт команды: http://www.bc.donetsk.ua\n Главный тренер: �?лек�?ей Ефимов\n",
    		"�?азвание команды: БК\"�?ЗОВМ�?Ш\"\n Город: Мариуполь\n �?рена: ПС �?зовмаш\n Сайт команды: http://www.bcazovmash.com.ua\n Главный тренер: Сергей Завалин\n",
    		"�?азвание команды: БК\"ГОВЕРЛ�?\"\n Город: Ивано-Франков�?к\n �?рена: Манеж КФВ\n Сайт команды: http://www.bcgoverla.if.ua\n Главный тренер: Евгений Мурзин\n",
    		"�?азвание команды: БК\"БУДИВЕЛЬ�?ИК\"\n Город: Киев\n �?рена: Дворец Спорта\n Сайт команды: http://www.budivelnyk.ua\n Главный тренер: �?йнара�? Багат�?ки�?\n",
    		"�?азвание команды: БК\"ХИМИК\"\n Город: Южный\n �?рена: ФСК Олимп\n Сайт команды: http://www.bc.khimik.com.ua\n Главный тренер: Звездан Митрович\n",
    		"�?азвание команды: БК\"ЧЕРК�?ССКИЕ М�?ВПЫ\"\n Город: Черка�?�?ы\n �?рена: ПС Будивельник\n Сайт команды: http://www.mavpabasket.com\n Главный тренер:Йовица �?р�?ич\n",
    		"�?азвание команды: БК\"ФЕРРО-З�?ТУ\"\n Город: Запорожье\n �?рена: З�?С\n Сайт команды: http://www.bcferro.com.ua\n Главный тренер: Кирилл Большаков\n",
    		"�?азвание команды: БК\"КРЫВБ�?ССБ�?СКЕТ\"\n Город: Кривой Рог\n �?рена: СК КТУ\n Сайт команды: http://www.krivbasbasket.com\n Главный тренер: Карли�? Мужниек�?\n",
    		"�?азвание команды: БК\"Г�?ЛИЧИ�?�?\"\n Город: Львов\n �?рена: ПС Галичина\n Сайт команды: http://www.bcpg.lviv.ua\n Главный тренер: Желько Лукаич\n",
    		"�?азвание команды: БК\"Д�?ЕПР\"\n Город: Днепропетров�?к\n �?рена: ПС Метеор\n Сайт команды: http://www.dnipro.ua\n Главный тренер: Вальдемара�? Хомичу�?\n",
    		"�?азвание команды: БК\"Д�?ЕПР-�?ЗОТ\"\n Город: Днепродзержин�?к\n �?рена: Дворец тенни�?а\n Сайт команды: http://www.bcazot.com\n Главный тренер: �?удрю�? Пракурайти�?\n",
    		"�?азвание команды: БК\"�?ИКОЛ�?ЕВ\"\n Город: �?иколаев\n �?рена: -\n Сайт команды: http://www.mbc.mk.ua\n Главный тренер: �?гри�? Гальвано�?ки�?\n"	    		    		
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